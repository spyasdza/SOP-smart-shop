# Pokemon-Shop
**SOP-Assignment-2**


## Store Data Using File
> **file_name**: AllPokemonData.txt


## URLs
| Method | URLs | Description|
| --- | --- | ---|
| GET | 127.0.0.1 | Home |
| GET | 127.0.0.1/show | Show all Pokemon |
| GET | 127.0.0.1/show/uuid={uuid} | Show Pokemon by UUID |
| GET | 127.0.0.1/show/name={name} | Show Pokemon by Name |
| POST | 127.0.0.1/add | Add a Pokemon to store |
| DELETE | 127.0.0.1/{uuid} | Buy a Pokemon |

## Example
#### 1. Home

> [GET] 127.0.0.1

```
Welcome to Pokemon Shop!

To see all Pokemon: '/show'
To add a Pokemon: '/add'
To see Pokemon by id: '/show/uuid={uuid}'
To see Pokemon by name: '/show/name={name}'
To buy a Pokemon: '/{uuid}'
```

#### 2. Show all Pokemon

> [GET] 127.0.0.1/show

```json
[
    {
        "uuid": "69f8dd64-4085-497e-a3d6-83ffa0d81f89",
        "name": "Pikachu",
        "price": 222.0
    },
    {
        "uuid": "dab38a3e-aba7-4a8b-a229-7dc7125e3a74",
        "name": "Togepi",
        "price": 50.0
    },
    {
        "uuid": "64caefee-afcc-4d4b-b2c0-8910120b3290",
        "name": "Dratini",
        "price": 300.0
    },
    {
        "uuid": "378994ee-77e7-4158-b1fd-1b38e97ad9ac",
        "name": "Mewtwo",
        "price": 500.0
    }
]
```

#### 3. Show Pokemon by UUID

> [GET] 127.0.0.1/show/uuid=69f8dd64-4085-497e-a3d6-83ffa0d81f89

```json
{
    "uuid": "69f8dd64-4085-497e-a3d6-83ffa0d81f89",
    "name": "Pikachu",
    "price": 222.0
}
```

#### 4. Show Pokemon by Name

> [GET] 127.0.0.1/show/name=Togepi

```json
[
    {
        "uuid": "dab38a3e-aba7-4a8b-a229-7dc7125e3a74",
        "name": "Togepi",
        "price": 50.0
    }
]
```

#### 5. Add a Pokemon to store

> [POST] 127.0.0.1/add

- Body
```json
{
	"name": "Raichu",
	"price": 60
}
```

- In File
```json
[
    {
        "uuid": "69f8dd64-4085-497e-a3d6-83ffa0d81f89",
        "name": "Pikachu",
        "price": 222.0
    },
    {
        "uuid": "dab38a3e-aba7-4a8b-a229-7dc7125e3a74",
        "name": "Togepi",
        "price": 50.0
    },
    {
        "uuid": "64caefee-afcc-4d4b-b2c0-8910120b3290",
        "name": "Dratini",
        "price": 300.0
    },
    {
        "uuid": "378994ee-77e7-4158-b1fd-1b38e97ad9ac",
        "name": "Mewtwo",
        "price": 500.0
    },
    {
        "uuid": "547e21d1-bede-4c09-a508-9c431efe734c",
        "name": "Raichu",
        "price": 60.0
    }
]
```

#### 6. Buy a Pokemon

> [DELETE] 127.0.0.1/69f8dd64-4085-497e-a3d6-83ffa0d81f89

```json
- In File
[
    {
        "uuid": "dab38a3e-aba7-4a8b-a229-7dc7125e3a74",
        "name": "Togepi",
        "price": 50.0
    },
    {
        "uuid": "64caefee-afcc-4d4b-b2c0-8910120b3290",
        "name": "Dratini",
        "price": 300.0
    },
    {
        "uuid": "378994ee-77e7-4158-b1fd-1b38e97ad9ac",
        "name": "Mewtwo",
        "price": 500.0
    },
    {
        "uuid": "547e21d1-bede-4c09-a508-9c431efe734c",
        "name": "Raichu",
        "price": 60.0
    }
]
```
