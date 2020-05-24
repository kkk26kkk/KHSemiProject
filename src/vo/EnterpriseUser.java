package vo;

import java.util.Date;

// 기업회원
public class EnterpriseUser {
  private String EID; // 기업회원ID
  private String ENAME; // 기업명
  private String ENUM; // 사업자번호
  private String EADDR; // 회사주소
  private String EADDR1; // 회사주소(도로명주소)
  private String EADDR2; // 회사주소(상세주소)
  private String OWNERNAME; // 대표자명
  private Date RGS_DTM; // 등록일시

  public String getEID() {
    return EID;
  }

  public void setEID(String eID) {
    EID = eID;
  }

  public String getENAME() {
    return ENAME;
  }

  public void setENAME(String eNAME) {
    ENAME = eNAME;
  }

  public String getENUM() {
    return ENUM;
  }

  public void setENUM(String eNUM) {
    ENUM = eNUM;
  }

  public String getEADDR() {
    return EADDR;
  }

  public void setEADDR(String eADDR) {
    EADDR = eADDR;
  }

  public String getEADDR1() {
    return EADDR1;
  }

  public void setEADDR1(String eADDR1) {
    EADDR1 = eADDR1;
  }

  public String getEADDR2() {
    return EADDR2;
  }

  public void setEADDR2(String eADDR2) {
    EADDR2 = eADDR2;
  }

  public String getOWNERNAME() {
    return OWNERNAME;
  }

  public void setOWNERNAME(String oWNERNAME) {
    OWNERNAME = oWNERNAME;
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

  private Date UPT_DTM; // 수정일시
}
