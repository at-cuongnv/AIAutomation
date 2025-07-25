# Test Cases ? Login Screen

| TC ID | Title | Pre-condition | Steps | Expected Result |
|-------|-------|--------------|-------|-----------------|
| TC01 | Screen initializes correctly | User is on `/login` route (fresh load) | 1. Navigate to `http://localhost:3000/login`<br>2. Wait for page to render | ? Login form displayed<br>? `Account` input is focused<br>? No error message shown |
| TC02 | Account input ? max length 10 | Login screen opened | 1. Type 11 characters into **Account** field | Only 10 characters are accepted / displayed |
| TC03 | Password input ? max length 10 | Login screen opened | 1. Type 11 characters into **Password** field | Only 10 characters are accepted / displayed |
| TC04 | Validation ? missing Account | Login screen opened | 1. Leave **Account** empty<br>2. Fill **Password** with any value<br>3. Click **Login** | ? Error banner appears with text `Account and password are required` |
| TC05 | Validation ? missing Password | Login screen opened | 1. Fill **Account** with any value<br>2. Leave **Password** empty<br>3. Click **Login** | ? Error banner appears with text `Account and password are required` |
| TC06 | Successful login as Admin | Valid admin user exists on backend (`account=admin`, `password=admin123`, role=`Admin`) | 1. Enter **Account** = `admin`<br>2. Enter **Password** = `admin123`<br>3. Click **Login** | ? Button shows *Logging in...* until response<br>? Browser navigates to `/admin/permission` |
| TC07 | Successful login as Staff | Valid staff user exists on backend (`account=staff`, `password=staff123`roleÅÇ`Admin`) | 1. Enter staff credentials<br>2. Click **Login** | ? Browser navigates to `/resource` |
| TC08 | Invalid credentials | Backend returns HTTP 4xx with `{ error: "Account not found or password incorrect." }` | 1. Enter wrong **Account** or **Password**<br>2. Click **Login** | ? Error banner shows backend message<br>? **Password** field is cleared |