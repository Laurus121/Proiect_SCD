package packagetracking.Courier;

public class ManagerDeliveredStats {
    private String managerName;
    private int deliveredCount;

    public ManagerDeliveredStats(String managerName, int deliveredCount) {
        this.managerName = managerName;
        this.deliveredCount = deliveredCount;
    }

    public String getManagerName() {
        return managerName;
    }

    public int getDeliveredCount() {
        return deliveredCount;
    }

    @Override
    public String toString() {
        return "ManagerDeliveredStats{" +
                "managerName='" + managerName + '\'' +
                ", deliveredCount=" + deliveredCount +
                '}';
    }
}

