import java.util.*;

class RideSharingSystem {
    private Deque<Integer> riders;
    private Deque<Integer> drivers;
    private Set<Integer> canceledRiders;

    public RideSharingSystem() {
        this.riders = new ArrayDeque<>();
        this.drivers = new ArrayDeque<>();
        this.canceledRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        // Clear any previous cancellation state for this rider ID
        canceledRiders.remove(riderId);
        riders.offerLast(riderId);
    }

    public void addDriver(int driverId) {
        drivers.offerLast(driverId);
    }

    public int[] matchDriverWithRider() {
        while (!riders.isEmpty() && canceledRiders.contains(riders.peekFirst())) {
            canceledRiders.remove(riders.pollFirst());
        }

        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[]{-1, -1};
        }

        int driver = drivers.pollFirst();
        int rider = riders.pollFirst();
        return new int[]{driver, rider};
    }

    public void cancelRider(int riderId) {
        canceledRiders.add(riderId);
    }
}