package vo;

import java.util.Date;

// �Ϲ� ȸ��
public class GeneralUser {
  private String GID; // �Ϲ�ȸ��ID
  private String NAME; // �̸�
  private String PW; // ��й�ȣ
  private String EMAIL; // �̸���
  private String PHONE; // �޴�����ȣ
  private Date RGS_DTM; // ����Ͻ�
  private Date UPT_DTM; // �����Ͻ�

  public String getGID() {
    return GID;
  }

  public void setGID(String gID) {
    GID = gID;
  }

  public String getNAME() {
    return NAME;
  }

  public void setNAME(String nAME) {
    NAME = nAME;
  }

  public String getPW() {
    return PW;
  }

  public void setPW(String pW) {
    PW = pW;
  }

  public String getEMAIL() {
    return EMAIL;
  }

  public void setEMAIL(String eMAIL) {
    EMAIL = eMAIL;
  }

  public String getPHONE() {
    return PHONE;
  }

  public void setPHONE(String pHONE) {
    PHONE = pHONE;
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
