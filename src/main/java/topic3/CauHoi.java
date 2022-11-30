package topic3;

import static topic3.CauHinh.sc;

import java.util.List;
import java.util.Objects;

public abstract class CauHoi {

    private static int dem = 0;
    private final int maCauHoi;
    private int mucDo;
    private String noiDung;
    private DanhMuc danhMuc;

    {
        maCauHoi = ++dem;
    }

    public CauHoi() {
    }

    public CauHoi(int mucDo, String noiDung, DanhMuc danhMuc) {
        this.mucDo = mucDo;
        this.noiDung = noiDung;
        this.danhMuc = danhMuc;
    }

    public static int getDem() {
        return dem;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public int getMucDo() {
        return mucDo;
    }

    public void setMucDo(int mucDo) {
        this.mucDo = mucDo;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public void nhapThongTin() {
        System.out.print("- Muc do: ");
        this.mucDo = Integer.parseInt(sc.nextLine());
        System.out.print("- Noi dung: ");
        this.noiDung = sc.nextLine();
    }

    public abstract List<MultipleChoice> getDsCauHoi();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CauHoi cauHoi = (CauHoi) o;
        return maCauHoi == cauHoi.maCauHoi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCauHoi);
    }

    @Override
    public String toString() {
        String lv = (mucDo == 1) ? "De" : (mucDo == 2 ? "Trung binh" : "Kho");
        return String.format("- Muc do: %s\t\t- Danh muc: %s\n- Noi dung: %s", lv, danhMuc.getTenDanhMuc(), noiDung);
    }
}