/**	
 * b.js
 */

function check() {
  if ($.trim($('#b_title').val()) == '') {
    alert("제목을 입력");
    $('#b_title').val('').focus();
    return false;
  }
  if ($.trim($('#b_cont').val()) == '') {
    alert("내용을 입력");
    $('#b_cont').val('').focus();
    return false;
  }
}