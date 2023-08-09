<!DOCTYPE html>
<html>
<head>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <title>My first Vue page</title>
  <style>
    #app > div {
      border: solid black 1px;
      width: 80%;
      padding: 10px;
      display: flex;
      flex-wrap: wrap;
    }
    img {
      width: 70px;
      margin: 10px;
    }
  </style>
</head>
<body>
<h1>Vue MPA</h1>
<div id="app">
<div class="container mt-3">
  <table  class="table table-striped">
    <tr v-for="x in posts">
    <td>{{ x.id }}</td>
    <td>{{ x.name }}</td>
    <td>{{ x.email }}</td>
    </tr>
  </table>
</div>
</div>
<script>
  const app = Vue.createApp({
   data() {
    return {
    	posts: []
    }
   },
   
   created() {
		fetch('/springmvc/rest/list')
		.then(response => response.json())  
        .then(data => this.posts = data)
	}
   
  })
  
  app.mount('#app')
</script>
</body>
</html>