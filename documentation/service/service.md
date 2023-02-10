Ticket servisinde 
Bir kaydı hem elasticsearch üzerinde hem de bu kaydı kalıcı hale getirmek için mysql db sine yazmak istiyoruz.


--Notification Servis: config ayarlarında kuyruğu dinleyen notification olduğu için input değerini verdik.
Output değeri kuyruğa yazan tarafından verilir. 
cloud:
stream:
bindings:
input:
destination: msqueue  