<Context>
FeatureName: Login
</Context>

<Instructions>
Đọc nội dung file test case [testcase/01_Screen_Login_TestCases.md], hãy sinh ra source code test tương ứng theo các nguyên tắc sau:

- Tuân theo phần hướng dẫn chung định nghĩa tại [instructions/test_automation_instruction.md].
- Tuân theo quy tắc khi viết mã được định nghĩa tại [promts/coding_rule.md].
- Nếu lớp LoginTest mới chưa xuất hiện trong testng.xml, được phép tự động cập nhật file testng.xml để thêm lớp test đó vào đúng suite phù hợp, nhưng phải giữ nguyên cấu trúc ban đầu của file.
</Instructions>

<Constraints>
✅ Sau khi sinh file LoginPage.java:

- Kiểm tra lại toàn bộ các selector trong file LoginPage.java.
- Đảm bảo các element tương ứng với mã nguồn HTML thực tế.
- Nếu không chắc chắn, hãy mở trang login, inspect element và xác nhận lại các id hoặc class.
- Nếu không tìm thấy element:
- Cập nhật lại selector, có thể chuyển sang sử dụng By.name, By.cssSelector, hoặc By.xpath nếu không tồn tại id.
✅ Sau khi sinh file LoginTest.java:

- Xác nhận rằng ứng dụng đã được chạy tại địa chỉ: http://localhost:3000/login.
- Có thể bổ sung thêm explicit wait phù hợp hơn:
- Đảm bảo hệ thống chờ đủ thời gian cho trang hoặc các element hiển thị đúng cách.

</Constraints>