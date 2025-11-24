package com.emergency.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emergency.model.Patient;
import com.emergency.util.DBUtil;

public class PatientDAOImpl implements PatientDAO {

	@Override
	public boolean addPatient(Patient p) {
		boolean flag = false;
		String sql = "Insert into patient (name, age, location, emergencyType , contact  ) values (?,?,?,?,?)";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getLocation());
			ps.setString(4, p.getEmergencyType());
			ps.setString(5, p.getContact());
			
			int rows = ps.executeUpdate();
			if (rows > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updatePatient(Patient p) {

		boolean flag = false;
		String sql = "Update patient set name =?, age=?, location=?,  contact=?, emergencyType=? where id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getLocation());
			ps.setString(4, p.getContact());
			ps.setString(5, p.getEmergencyType());
			ps.setInt(6, p.getId());

			int rows = ps.executeUpdate();
			if (rows > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deletePatient(int id) {
		 boolean flag = false;
	        String sql = "DELETE FROM patient WHERE id=?";

	        try (Connection con = DBUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);

	            int rows = ps.executeUpdate();
	            if (rows > 0) flag = true;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return flag;
	}

	@Override
	public Patient getPatientById(int id) {
		Patient p = null;
        String sql = "SELECT * FROM patient WHERE id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Patient();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setLocation(rs.getString("location"));  
                p.setContact(rs.getString("contact"));
                p.setEmergencyType(rs.getString("emergencyType"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
	}

	@Override
	public List<Patient> getAllPatients() {
		 List<Patient> list = new ArrayList<>();
	        String sql = "SELECT * FROM patient";

	        try (Connection con = DBUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                Patient p = new Patient();
	                p.setId(rs.getInt("id"));
	                p.setName(rs.getString("name"));
	                p.setAge(rs.getInt("age"));
	                p.setLocation(rs.getString("location"));
	                p.setEmergencyType(rs.getString("emergencyType"));
	                p.setContact(rs.getString("contact"));
	                list.add(p);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

}
