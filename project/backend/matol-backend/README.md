# MATOL BACKEND USAGE TUTORIAL

Simple steps to use backend.

## Docker

Go to location whre is a docker-compose file -  /project/docker then use:

```bash
sudo docker-compose up -d
```

## 1. REGISTER USER
Register user use method post in postman
```http://localhost:8000/api/v1/registration```

```
{
    "username": "Matayyy",
    "email": "matay@email.com",
    "password": "password"
}
```

## 2. LOCAL MAIL
Confirm new account on ```http://localhost:1080```

## 3. LOGIN
Now u have access to account. To login go: ```http://localhost:8000/login```

## 4. GET ALL CUSTOMERS (requried login)
When u are loged use u have access to endpoints:
```http://localhost:8000/api/v1/customers ```

## 5. LOGOUT
```http://localhost:8000/logout```