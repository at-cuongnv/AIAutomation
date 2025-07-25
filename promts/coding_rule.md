✅ Quy tắc tạo mã kiểm thửa tự động

Vui lòng tạo test kiểm thửa giao diện tự động bằng Selenium (Java) tuân theo các nguyên tắc sau:

🔧 Nguyên tắc chung:

Áp dụng mô hình thiết kế Page Object Model (POM).

Sử dụng kỹ thuật đồng bộ hợp lý (ưu tiên dùng explicit wait).

Không hard-code dữ liệu – thay vào đó sử dụng biến, hằng số hoặc cấu hình.

Ghi log rõ ràng cho từng bước và từng assertion trong quá trình kiểm thửa.

Thêm chú thích (comment) ở những đoạn cần thiết để dễ hiểu và bảo trì.

Tuân theo mô hình viết test: Arrange – Act – Assert.

Tất cả các class Test phải kế thừa từ BaseTest; các class Page phải kế thừa từ BasePage.

Tên class Test phải kết thúc bằng Test và chứa tên tính năng, ví dụ: LoginTest, AuthenTest.

Mỗi class test mới phải được thêm vào file testng.xml trong phần <suite> phù hợp.

Nếu test mới chưa có trong testng.xml, được phép tự động cập nhật file testng.xml, nhưng phải giữ nguyên cấu trúc ban đầu của file.

🧪 Định dạng mẫu cho 1 test case:

Trường

Nội dung mô tả

Mục tiêu

[Mô tả mục tiêu của test case này là gì]

Ngữ cảnh

[Tên trang hoặc chức năng đang được test]

Hành vi

[Liệt kê các bước tương tác giao diện từng bước một]

Kỳ vọng

[Kết quả mong đợi sau khi thực hiện các bước hành vi]

Ràng buộc

[Ví dụ: chỉ chạy được trên Chrome, cần đăng nhập trước,...]

📌 Lưu ý:

Mã test chỉ được cập nhật vào kho mã (source control) sau khi được review và chấp thuận.

Tên test case và cấu trúc thư mục phải tuân theo tiêu chuẩn đặt tên và tổ chức mã nguồn của team.