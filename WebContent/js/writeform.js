
$(document).ready(function() {
    // ���� ��ư Ŭ���� �� �̺�Ʈ �κ�
    $("form").submit(function() {
       
       if ($.trim($("input").eq(1).val()) == "") {
        alert("��й�ȣ�� �Է��ϼ���");
        $("input:eq(1)").focus();
        return false;
       }
       if ($.trim($("input").eq(2).val()) == "") {
           alert("������ �Է��ϼ���");
           $("input:eq(2)").focus();
           return false;
        }
                   
       if ($.trim($("textarea").val()) == "") {
           alert("������ �Է��ϼ���");
           $("textarea").focus();
           return false;
        }
       
      });
    
    $("#upfile").change(function(){
    	$('#filevalue').val('');
    	var inputfile=$(this).val().split('\\');
    	$('#filevalue').text(inputfile[inputfile.length-1]);
    });

   });//ready() end 