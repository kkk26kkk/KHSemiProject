package vo;

import java.util.Date;

// ���ȸ��-�λ�����
public class EnterpriseHrd {
  private String EID; // ���ȸ��ID
  private String SN; // �Ϸù�ȣ
  private String PW; // ��й�ȣ
  private String HRDNAME; // ����ڸ�
  private String PHONE; // ��ȭ��ȣ
  private String EMAIL; // �̸���
  private Date RGS_DTM; // ����Ͻ�
  private Date UPT_DTM; // �����Ͻ�

  public String getEID() {
    return EID;
  }

  public void setEID(String eID) {
    EID = eID;
  }

  public String getSN() {
    return SN;
  }

  public void setSN(String sN) {
    SN = sN;
  }

  public String getPW() {
    return PW;
  }

  public void setPW(String pW) {
    PW = pW;
  }

  public String getHRDNAME() {
    return HRDNAME;
  }

  public void setHRDNAME(String hRDNAME) {
    HRDNAME = hRDNAME;
  }

  public String getPHONE() {
    return PHONE;
  }

  public void setPHONE(String pHONE) {
    PHONE = pHONE;
  }

  public String getEMAIL() {
    return EMAIL;
  }

  public void setEMAIL(String eMAIL) {
    EMAIL = eMAIL;
  }

  public Date getRGS_DTM() {
    return RGS_DTM;
  }

  public void setRGS_DTM(Date rGS_DTM) {
    RGS_DTM = rGS_DTM;
  }

  public Date getUPT_DTM() {
    return UPT_DTM;
  }

  public void setUPT_DTM(Date uPT_DTM) {
    UPT_DTM = uPT_DTM;
  }

}
