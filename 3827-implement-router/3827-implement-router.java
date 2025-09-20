class Router {

    static class Packet {
        int src;
        int des;
        int time;

        Packet(int s, int d, int t) {
            src = s;
            des = d;
            time = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Packet))
                return false;
            Packet packet = (Packet) o;
            return src == packet.src &&
                    des == packet.des &&
                    time == packet.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, des, time);
        }
    }

    private int limit = 0;

    private Queue<Packet> q = new LinkedList<>();
    private Set<Packet> st = new HashSet<>();
    private Map<Integer, List<Integer>> mpp = new HashMap<>();

    public Router(int memoryLimit) {
        limit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);

        if (st.contains(p)) {
            return false;
        }

        if (q.size() >= limit) {
            forwardPacket();
        }

        q.add(p);
        st.add(p);

        List<Integer> timeArr = mpp.computeIfAbsent(destination, k -> new ArrayList<>());
        timeArr.add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (!q.isEmpty()) {
            Packet p = q.poll();

            st.remove(p);
            List<Integer> arr = mpp.get(p.des);
            arr.remove(0);

            return new int[] { p.src, p.des, p.time };
        }

        return new int[] {};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> arr = mpp.get(destination);

        if (arr != null && !arr.isEmpty()) {
            return ub(arr, endTime) - lb(arr, startTime);
        } else {
            return 0;
        }
    }

    int lb(List<Integer> arr, int time) {

        int n = arr.size();
        int low = 0, high = n - 1;

        int ans = n;
        while (low <= high) {
            int mid = (low + high) >> 1;

            if (arr.get(mid) >= time) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    int ub(List<Integer> arr, int time) {

        int n = arr.size();
        int low = 0, high = n - 1;

        int ans = n;
        while (low <= high) {
            int mid = (low + high) >> 1;

            if (arr.get(mid) > time) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */