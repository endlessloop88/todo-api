# 🚀 Todo API - Spring Boot Layered Architecture

Bu proje, kurumsal standartlara uygun olarak **Katmanlı Mimari (Layered Architecture)** prensipleriyle geliştirilmiş, veri doğrulama (validation) mekanizmalarına sahip gelişmiş bir RESTful Todo API projesidir.

## 🛠️ Kullanılan Teknolojiler & Kütüphaneler
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA** (Veri Erişim Katmanı)
- **Jakarta Validation** (Veri Doğrulama Katmanı)
- **H2 Database** (In-Memory Veritabanı)
- **Maven** (Bağımlılık Yönetimi)

## 🏗️ Mimari Yapı (Layered Architecture)
Proje, modülerlik, okunabilirlik ve sürdürülebilirlik odaklı 3 temel katmandan oluşmaktadır:
1. **Controller Katmanı (`TodoApiApplication`):** REST endpoint'lerini barındırır, dış dünyadan gelen istekleri karşılar ve veri doğrulama (Validation) filtresini işletir.
2. **Service Katmanı (`TodoService`):** İş mantığının (Business Logic) döndüğü, kurumsal kuralların uygulandığı ana yönetim katmandır.
3. **Repository Katmanı (`TodoRepository`):** Veritabanı ile doğrudan güvenli iletişim kuran ve CRUD operasyonlarını yöneten soyutlama katmandır.

## 🔐 Veri Doğrulama (Validation) Kuralları
Sistem güvenliği ve veri tutarlılığı için gelen istekler şu filtrelere tabi tutulur:
- `title`: Boş bırakılamaz (`@NotBlank`) ve minimum 3, maksimum 100 karakter olmalıdır (`@Size`).

## 🛣️ API Uçları (Endpoints)
| Metot | Endpoint | Açıklama |
| :--- | :--- | :--- |
| **GET** | `/api/todos` | Sistemdeki tüm görevleri listeler. |
| **POST** | `/api/todos` | Yeni bir görev ekler (Doğrulama filtresinden geçer). |
| **PUT** | `/api/todos/{id}` | Belirtilen ID'ye sahip görevi günceller. |
| **DELETE**| `/api/todos/{id}` | Belirtilen ID'ye sahip görevi siler. |

## 🚀 Projeyi Yerelde Çalıştırma
Projeyi klonladıktan sonra ana dizinde terminalden şu komutu çalıştırarak uygulamayı `8089` portu üzerinden ayağa kaldırabilirsiniz:
```bash
./mvnw clean spring-boot:run
