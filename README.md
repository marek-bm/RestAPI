# RestAPI

This mini service was created realizing REST concept. Endpoints expose the data in JSON/HAL format. <br> 
It performs CRUD operations on the Item entity.
git http://localhost:8080/api/items/

<table>
<thead>
    <tr>
        <th>HTTP Method</th>
        <th>URI</th>
        <th>Description</th>
    </tr>
</thead>
<tbody>
    <tr>
        <td>GET</td>
        <td>/api/items</td>
        <td>List all items</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/api/items</td>
        <td>Save an item</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/api/items/{id}</td>
        <td>Find an item where by {id}</td>
    </tr>
    <tr>
        <td>PUT</td>
        <td>/api/items</td>
        <td>Update an item</td>
    </tr>
    <tr>
        <td>PATCH</td>
        <td>/api/items/{id}</td>
        <td>Update fields </td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>/api/items/{id}</td>
        <td>Delete an item </td>
    </tr>
</tbody>
</table>

Technology used:
<ul>
<li> Spring Boot + Web / Data / Hateoas starters </li>
<li> Hibernate as JPA provider </li>
<li> H2 database</li>
<li> Lombok </li>
</ul>

