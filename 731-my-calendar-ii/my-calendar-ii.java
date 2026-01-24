class MyCalendarTwo {
List<int[]> track;
List<int[]> doubleBook;
    public MyCalendarTwo() {
       track = new ArrayList<>();
                doubleBook = new ArrayList<>();

    }
    
    public boolean book(int startTime, int endTime) {
       for (int[] event : doubleBook) {
            if (Math.max(startTime, event[0]) < Math.min(endTime, event[1])) {
                return false;  // Triple booking would happen, reject the booking
            }
        }

        // Check for overlaps with single bookings and store double bookings
        for (int[] event : track) {
            if (Math.max(startTime, event[0]) < Math.min(endTime, event[1])) {
                // Store the overlapping part as a new double booking
                doubleBook.add(new int[]{Math.max(startTime, event[0]), Math.min(endTime, event[1])});
            }
        }

        // Add the new booking to single bookings
        track.add(new int[]{startTime, endTime});
        return true;
     
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */