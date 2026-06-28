# 📝 Todo Management API (Spring Boot & PostgreSQL)

Bu proje, modern yazılım mimarilerine ve temiz kod (clean code) prensiplerine uygun olarak geliştirilmiş, ilişkisel veritabanı destekli bir **Görev Yönetimi (Todo Management) RESTful API** uygulamasıdır.

---

## 🛠️ Kullanılan Teknolojiler & Araçlar
* **Backend Framework:** Java 17 / Spring Boot 3.x
* **Veri Erişimi & ORM:** Spring Data JPA / Hibernate
* **Veritabanı:** PostgreSQL
* **API Test & Dokümantasyon:** Postman / Swagger UI
* **Bağımlılık Yönetimi:** Maven
* **Versiyon Kontrolü:** Git / GitHub

---

## 🚀 Öne Çıkan Teknik Özellikler & Çözümler

* **Katmanlı Mimari (Layered Architecture):** Proje; `Controller`, `Service`, `Repository` ve `Entity` katmanlarına ayrılarak loose coupling (gevşek bağlılık) ve yüksek sürdürülebilirlik prensiplerine uygun olarak inşa edilmiştir.
* **Sonsuz Döngü (Infinite Recursion) Optimizasyonu:** İlişkisel veritabanı modellerinde (One-to-Many / Many-to-One) sıkça karşılaşılan JSON serileştirme döngüleri, `@JsonIgnoreProperties` ve DTO (Data Transfer Object) mimarisi kullanılarak optimize edilmiştir.
* **Veri Doğrulama (Validation):** İstek gövdelerindeki verilerin doğruluğu Spring Validation mimarisiyle kontrol altına alınmıştır.

---

## 🔗 API Uç Noktaları (Endpoints)

### Görev (Todo) Yönetimi
| Metot | Uç Nokta (Endpoint) | Açıklama |
| :--- | :--- | :--- |
| **GET** | `/api/todos` | Tüm görevleri listeler. |
| **GET** | `/api/todos/{id}` | ID'ye göre belirli bir görevi getirir. |
| **POST** | `/api/todos` | Yeni bir görev oluşturur. |
| **PUT** | `/api/todos/{id}` | Mevcut bir görevi günceller. |
| **DELETE** | `/api/todos/{id}` | Belirli bir görevi siler. |

---

## 💻 Projeyi Yerelde Çalıştırma

1. Projeyi klonlayın:
   ```bash
   git clone [https://github.com/KULLANICI_ADIN/PROJE_ADIN.git](https://github.com/KULLANICI_ADIN/PROJE_ADIN.git)
