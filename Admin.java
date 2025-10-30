public class Admin extends Staff {
    private String permissions;

    public Admin(String staffId, String name, String role, String permissions) {
        super(staffId, name, role);
        this.permissions = permissions;
    }

    public void manageStaff(Staff staff, String action) {
        // Implementation for managing staff (add/remove/update)
        if ("add".equalsIgnoreCase(action)) {
            // Add staff logic
            System.out.println("Adding staff: " + staff.getName());
        } else if ("remove".equalsIgnoreCase(action)) {
            // Remove staff logic
            System.out.println("Removing staff: " + staff.getName());
        }
    }
    
    public void generateReport(String reportType) {
        System.out.println("Generating " + reportType + " report...");
        // Implementation for generating reports
    }
    
    public String getPermissions() {
        return permissions;
    }
    
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
