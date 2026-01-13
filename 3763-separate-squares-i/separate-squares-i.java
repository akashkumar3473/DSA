

class Solution {
    static class Event {
        long y;
        long widthChange;

        Event(long y, long widthChange) {
            this.y = y;
            this.widthChange = widthChange;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        double totalArea = 0;

        // Create events
        for (int[] sq : squares) {
            long y = sq[1];
            long l = sq[2];
            totalArea += (double) l * l;

            events.add(new Event(y, l));      
            events.add(new Event(y + l, -l));  
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        double halfArea = totalArea / 2.0;
        double area = 0;
        long width = 0;
        long prevY = events.get(0).y;

        // Sweep line
        for (Event e : events) {
            long currY = e.y;
            double deltaY = currY - prevY;
            double gainedArea = width * deltaY;

            if (area + gainedArea >= halfArea) {
                return prevY + (halfArea - area) / width;
            }

            area += gainedArea;
            width += e.widthChange;
            prevY = currY;
        }

        return prevY;
    }
}
