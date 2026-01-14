class SegmentTree {
    int n;
    int[] coverCount;
    double[] coveredLen;
    double[] xcoords;

    SegmentTree(List<Long> coords) {
        n = coords.size() - 1;
        xcoords = new double[coords.size()];
        for (int i = 0; i < coords.size(); i++) {
            xcoords[i] = coords.get(i);
        }
        coverCount = new int[4 * n];
        coveredLen = new double[4 * n];
    }

    void clear() {
        Arrays.fill(coverCount, 0);
        Arrays.fill(coveredLen, 0.0);
    }

    void updateRange(int idx, int left, int right, int ql, int qr, int val) {
        if (ql > right || qr < left) return;
        if (ql <= left && right <= qr) {
            coverCount[idx] += val;
        } else {
            int mid = (left + right) >> 1;
            updateRange(idx << 1, left, mid, ql, qr, val);
            updateRange((idx << 1) + 1, mid + 1, right, ql, qr, val);
        }

        if (coverCount[idx] > 0) {
            coveredLen[idx] = xcoords[right + 1] - xcoords[left];
        } else {
            if (left == right) {
                coveredLen[idx] = 0.0;
            } else {
                coveredLen[idx] = coveredLen[idx << 1] + coveredLen[(idx << 1) + 1];
            }
        }
    }

    void update(long xl, long xr, int val) {
        if (xl >= xr) return;
        int l = lowerBound(xcoords, xl);
        int r = lowerBound(xcoords, xr);
        if (l < r) {
            updateRange(1, 0, n - 1, l, r - 1, val);
        }
    }

    double getCoveredLength() {
        return coveredLen[1];
    }

    private int lowerBound(double[] arr, double val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < val) l = m + 1;
            else r = m;
        }
        return l;
    }
}

class Event implements Comparable<Event> {
    long y, x1, x2;
    int type;

    Event(long y, long x1, long x2, int type) {
        this.y = y;
        this.x1 = x1;
        this.x2 = x2;
        this.type = type;
    }

    @Override
    public int compareTo(Event other) {
        if (this.y != other.y) return Long.compare(this.y, other.y);
        return Integer.compare(this.type, other.type);
    }
}

public class Solution {
    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        List<Long> xvals = new ArrayList<>();

        for (int[] sq : squares) {
            long x = sq[0], y = sq[1], l = sq[2];
            long x2 = x + l, y2 = y + l;
            events.add(new Event(y, x, x2, +1));
            events.add(new Event(y2, x, x2, -1));
            xvals.add(x);
            xvals.add(x2);
        }

        Collections.sort(xvals);
        xvals = new ArrayList<>(new HashSet<>(xvals));
        Collections.sort(xvals);

        Collections.sort(events);

        SegmentTree st = new SegmentTree(xvals);

        double totalArea = 0.0;
        if (!events.isEmpty()) {
            st.update(events.get(0).x1, events.get(0).x2, events.get(0).type);
            double coverage = st.getCoveredLength();
            double prevY = events.get(0).y;

            for (int i = 1; i < events.size(); i++) {
                double curY = events.get(i).y;
                double deltaY = curY - prevY;
                totalArea += coverage * deltaY;

                st.update(events.get(i).x1, events.get(i).x2, events.get(i).type);
                coverage = st.getCoveredLength();
                prevY = curY;
            }
        }

        if (Math.abs(totalArea) < 1e-15) {
            long minY = Long.MAX_VALUE;
            for (int[] sq : squares) {
                minY = Math.min(minY, sq[1]);
            }
            return minY;
        }

        double halfArea = totalArea / 2.0;

        st.clear();
        double partialArea = 0.0;
        double resultY = 0.0;

        if (!events.isEmpty()) {
            st.update(events.get(0).x1, events.get(0).x2, events.get(0).type);
            double coverage = st.getCoveredLength();
            double prevY = events.get(0).y;

            for (int i = 1; i < events.size(); i++) {
                double curY = events.get(i).y;
                double deltaY = curY - prevY;
                double segmentArea = coverage * deltaY;

                if (partialArea + segmentArea >= halfArea - 1e-15) {
                    if (Math.abs(coverage) < 1e-15) {
                        if (Math.abs(partialArea - halfArea) < 1e-9) {
                            return prevY;
                        }
                    } else {
                        double needed = halfArea - partialArea;
                        double yOffset = needed / coverage;
                        return prevY + yOffset;
                    }
                }

                partialArea += segmentArea;
                st.update(events.get(i).x1, events.get(i).x2, events.get(i).type);
                coverage = st.getCoveredLength();
                prevY = curY;
            }

            return prevY;
        }

        return 0.0;
    }
}