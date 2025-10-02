import java.sql.*;

public class MedBusSystem {

    // ------------------ PATIENT SIDE ------------------
    public void raiseRequest(User user, String emergencyType) {
        try (Connection conn = DBConnection.getConnection()) {
            
            // 1. Insert user first
            String userSql = "INSERT INTO users(name, age, location, contact) VALUES (?,?, ?, ?)";
            PreparedStatement psUser = conn.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, user.name);
            psUser.setInt(2, user.age); 
            psUser.setString(3, user.location);
            psUser.setString(4, user.contact);
            psUser.executeUpdate();

            // Get user id (auto-increment)
            ResultSet rs = psUser.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }

            // 2. Insert request
            String reqSql = "INSERT INTO requests(user_id, emergency_type, status) VALUES (?, ?, 'Pending')";
            PreparedStatement psReq = conn.prepareStatement(reqSql);
            psReq.setInt(1, userId);
            psReq.setString(2, emergencyType);
            psReq.executeUpdate();

            System.out.println("✅ Request saved in database successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ------------------ COMMON ------------------
    public void viewRequests() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT r.id, u.name, u.age, u.location, u.contact, r.emergency_type, r.status " +
                         "FROM requests r JOIN users u ON r.user_id = u.id ORDER BY r.id DESC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n=== REQUEST LIST ===");
            while (rs.next()) {
                System.out.println("RequestID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") +
                                   ", Location: " + rs.getString("location") +
                                   ", Contact: " + rs.getString("contact") +
                                   ", Emergency: " + rs.getString("emergency_type") +
                                   ", Status: " + rs.getString("status"));
            }
            System.out.println("====================\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ------------------ ADMIN SIDE ------------------
    public void updateRequestStatus(int requestId, String newStatus) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE requests SET status=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newStatus);
            ps.setInt(2, requestId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Request ID " + requestId + " updated to '" + newStatus + "'");
            } else {
                System.out.println(" Request ID not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
