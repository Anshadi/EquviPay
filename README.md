# ExpenseShare - Collaborative Expense Management System

A full-stack application for managing shared expenses with friends, roommates, and groups. Split bills easily with intelligent balance calculations and settlement recommendations.

## 🌟 Features

### Backend (Spring Boot)
- **Group Management**: Create and manage expense groups with multiple members
- **Expense Tracking**: Add expenses with flexible split strategies (Equal/Percentage)
- **Smart Settlements**: Optimal balance calculation using advanced algorithms
- **Database Migration**: Flyway integration for schema management
- **RESTful API**: Clean REST endpoints for all operations

### Frontend (React TypeScript)
- **Modern UI**: Clean, responsive design with Tailwind CSS
- **Dashboard**: Comprehensive overview of expenses and balances
- **Real-time Updates**: Live expense tracking and balance calculations
- **Mobile Responsive**: Works seamlessly across all devices
- **Type Safety**: Full TypeScript implementation

## 🛠 Technology Stack

### Backend
- **Framework**: Spring Boot 3.4.4
- **Language**: Java 22
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA with Hibernate
- **Migration**: Flyway
- **Build Tool**: Gradle
- **Connection Pooling**: HikariCP

### Frontend
- **Framework**: React 18 with TypeScript
- **Styling**: Tailwind CSS
- **Routing**: React Router DOM
- **HTTP Client**: Axios
- **Build Tool**: Create React App

## 🚀 Quick Start

### Prerequisites
- Java 22 or higher
- Node.js 14+ and npm
- MySQL 8.0
- Git

### Backend Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/expense-share-app.git
   cd expense-share-app
   ```

2. **Database Setup**:
   ```sql
   CREATE DATABASE expense_db;
   CREATE USER 'expense_user'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON expense_db.* TO 'expense_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

3. **Configure Environment**:
   Create `.env` file in the root directory:
   ```env
   DB_URL=jdbc:mysql://localhost:3306/expense_db
   DB_USERNAME=expense_user
   DB_PASSWORD=your_password
   ```

4. **Run the Backend**:
   ```bash
   ./gradlew bootRun
   ```
   Backend will be available at `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**:
   ```bash
   cd frontend
   ```

2. **Install dependencies**:
   ```bash
   npm install
   ```

3. **Start development server**:
   ```bash
   npm start
   ```
   Frontend will be available at `http://localhost:3000`

## 📁 Project Structure

```
expense-share-app/
├── src/main/java/com/example/expenseshare/
│   ├── controllers/          # REST Controllers
│   ├── models/              # Entity Models
│   ├── repositories/        # JPA Repositories
│   ├── services/            # Business Logic
│   ├── dto/                 # Data Transfer Objects
│   └── config/              # Configuration Classes
├── src/main/resources/
│   ├── db/migrations/       # Flyway SQL Migrations
│   └── application.yaml     # Application Configuration
├── frontend/
│   ├── src/
│   │   ├── components/      # React Components
│   │   ├── services/        # API Services
│   │   ├── types/           # TypeScript Types
│   │   └── App.tsx          # Main App Component
│   └── public/              # Static Assets
└── build.gradle            # Gradle Build Configuration
```

## 🔗 API Endpoints

### Groups
- `POST /api/groups/create` - Create a new group
- `GET /api/groups/{id}` - Get group details
- `POST /api/groups/{id}/add` - Add member to group
- `DELETE /api/groups/{id}/remove` - Remove member from group

### Expenses
- `POST /api/expenses/add` - Add new expense
- `GET /api/expenses/user/{userId}` - Get user's expenses

### Settlement
- `GET /api/settleup/user/{userId}` - Get user's settlement recommendations
- `GET /api/settleup/group/{groupId}` - Get group's settlement recommendations

## 💡 Core Concepts

### Split Strategies
- **Equal Split**: Divides expense equally among all participants
- **Percentage Split**: Divides expense based on custom percentages

### Settlement Algorithm
The application uses an optimized algorithm to minimize the number of transactions needed to settle all balances within a group.

### Data Models
- **User**: Basic user information
- **ExpenseGroup**: Groups with multiple members
- **Expense**: Individual expense records
- **Split**: Individual share of an expense for each user

## 🎯 Usage Examples

### Creating a Group
1. Navigate to Groups page
2. Click "Create Group"
3. Enter group name and select members
4. Click "Create Group"

### Adding an Expense
1. Go to Expenses page
2. Click "Add Expense"
3. Fill in description, amount, and split type
4. Select participants and payment details
5. Submit the expense

### Settling Up
1. Visit Settlement page
2. View your balance summary
3. Follow settlement recommendations
4. Track who owes whom

## 🧪 Testing

### Backend Tests
```bash
./gradlew test
```

### Frontend Tests
```bash
cd frontend
npm test
```

## 📊 Database Schema

The application uses Flyway migrations to manage database schema:

- **V1**: Initial schema setup
- **V2**: User table modifications
- **V3**: User table recreation
- **V4**: Expense group table
- **V5**: Audit columns
- **V6**: Expense and split tables
- **V7**: Timestamp columns
- **V8**: Created by relationships

## 🔒 Security Considerations

- Input validation on all endpoints
- SQL injection prevention through JPA
- CORS configuration for frontend integration
- Environment-based configuration

## 🚀 Deployment

### Backend Deployment
1. Build the JAR file:
   ```bash
   ./gradlew bootJar
   ```

2. Run in production:
   ```bash
   java -jar build/libs/ExpenseShare-0.0.1-SNAPSHOT.jar
   ```

### Frontend Deployment
1. Build for production:
   ```bash
   cd frontend
   npm run build
   ```

2. Serve the built files using any web server

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new features
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- React team for the robust frontend framework
- Tailwind CSS for the utility-first CSS framework

## 📞 Support

For support, email your-email@example.com or create an issue in the GitHub repository.

---

**Resume Summary**: *Developed a full-stack expense sharing application using Spring Boot and React TypeScript, featuring intelligent balance calculations, RESTful APIs, and modern responsive UI with Tailwind CSS.*
