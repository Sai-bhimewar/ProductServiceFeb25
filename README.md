ProductService
ProductService is a e-commerce website build with help of Fakestore api.

Get all products
fetch("https://fakestoreapi.com/products")
  .then((res) => res.json())
  .then((json) => console.log(json));
Get a single product
fetch("https://fakestoreapi.com/products/1")
  .then((res) => res.json())
  .then((json) => console.log(json));
Add new product
fetch("https://fakestoreapi.com/products", {
  method: "POST",
  body: JSON.stringify({
    title: "test product",
    price: 13.5,
    description: "lorem ipsum set",
    image: "https://i.pravatar.cc",
    category: "electronic",
  }),
})
  .then((res) => res.json())
  .then((json) => console.log(json));

/* will return
{
 id:31,
 title:'...',
 price:'...',
 category:'...',
 description:'...',
 image:'...'
}
*/
Note: Posted data will not really insert into the database and just return a fake id.

Updating a product
fetch("https://fakestoreapi.com/products/7", {
  method: "PUT",
  body: JSON.stringify({
    title: "test product",
    price: 13.5,
    description: "lorem ipsum set",
    image: "https://i.pravatar.cc",
    category: "electronic",
  }),
})
  .then((res) => res.json())
  .then((json) => console.log(json));

/* will return
{
    id:7,
    title: 'test product',
    price: 13.5,
    description: 'lorem ipsum set',
    image: 'https://i.pravatar.cc',
    category: 'electronic'
}
*/
fetch("https://fakestoreapi.com/products/8", {
  method: "PATCH",
  body: JSON.stringify({
    title: "test product",
    price: 13.5,
    description: "lorem ipsum set",
    image: "https://i.pravatar.cc",
    category: "electronic",
  }),
})
  .then((res) => res.json())
  .then((json) => console.log(json));

/* will return
{
    id:8,
    title: 'test product',
    price: 13.5,
    description: 'lorem ipsum set',
    image: 'https://i.pravatar.cc',
    category: 'electronic'
}
*/
Note: Edited data will not really be updated into the database.

Deleting a product
fetch("https://fakestoreapi.com/products/8", {
  method: "DELETE",
});
Nothing will delete on the database.

Sort and Limit
You can use query string to limit results or sort by asc|desc

// Will return all the posts that belong to the first user
fetch("https://fakestoreapi.com/products?limit=3&sort=desc")
  .then((res) => res.json())
  .then((json) => console.log(json));
All available routes
Products
fields:
{
    id:Number,
    title:String,
    price:Number,
    category:String,
    description:String,
    image:String
}
GET:

/products (get all products)
/products/1 (get specific product based on id)
/products?limit=5 (limit return results )
/products?sort=desc (asc|desc get products in ascending or descending orders (default to asc))
/products/products/categories (get all categories)
/products/category/jewelery (get all products in specific category)
/products/category/jewelery?sort=desc (asc|desc get products in ascending or descending orders (default to asc))
POST:

/products
-PUT,PATCH

/products/1
-DELETE

/products/1
