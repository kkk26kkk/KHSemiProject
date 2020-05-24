package vo;

import java.util.Date;

// 기업회원-인사담당자
public class EnterpriseHrd {
  private String EID; // 기업회원ID
  private String SN; // 일련번호
  private String PW; // 비밀번호
  private String HRDNAME; // 담당자명
  private String PHONE; // 전화번호
  private String EMAIL; // 이메일
  private Date RGS_DTM; // 등록일시
  private Date UPT_DTM; // 수정일시

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
