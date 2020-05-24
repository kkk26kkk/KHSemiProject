package vo;

import java.util.Date;

// 일반 회원
public class GeneralUser {
  private String GID; // 일반회원ID
  private String NAME; // 이름
  private String PW; // 비밀번호
  private String EMAIL; // 이메일
  private String PHONE; // 휴대폰번호
  private Date RGS_DTM; // 등록일시
  private Date UPT_DTM; // 수정일시

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
