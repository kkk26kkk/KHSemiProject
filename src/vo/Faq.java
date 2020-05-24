package vo;

import java.util.Date;

// 문의사항
public class Faq {
  private int SN; // 일련번호
  private String USERID; // 회원ID
  private String FAQPW; // 글비밀번호
  private String SUBJECT; // 제목
  private String CONTENT; // 내용
  private int RE_REF; // 답변 글 작성 시 참조되는 글의 번호
  private int RE_LEV; // 답변 글의 깊이
  private int RE_SEQ; // 답변 글의 순서
  private int READCOUNT; // 글 조회수
  private Date RGS_DTM; // 등록일시
  private Date UPT_DTM; // 수정일시
}
