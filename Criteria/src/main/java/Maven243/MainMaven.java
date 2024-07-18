package Maven243;

import java.util.List;
import Maven243.dao.NhanVienDao;
import Maven243.NhanVien;

public class MainMaven {
    public static void main(String[] args) {
        NhanVienDao nhanVienDAO = new NhanVienDao();
        List<NhanVien> nhanVienList = nhanVienDAO.getAllNhanVien();
        
        if (nhanVienList != null && !nhanVienList.isEmpty()) {
            for (NhanVien nv : nhanVienList) {
                System.out.println("Tên nhân viên: " + nv.getTenNv());
            }
        } else {
            System.out.println("No employees found.");
        }
    }
}
