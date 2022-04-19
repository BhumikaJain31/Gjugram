<template>
<div>
  <navBar />
  <div class="bg">
    <link
      rel="stylesheet"
      href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
      integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
      crossorigin="anonymous"
    />
    <h2 class="cart_heading">Add new Post</h2>
    <form class="pure-form pure-form-aligned form" @submit="addPost">
      <fieldset>
        <div class="pure-control-group">
          <label for="details">Enter Post URL:</label>
          <input
            class="form_field"
            type="text"
            placeholder="Enter Post URL"
            v-model="image"
          />
        </div>

        <div class="pure-control-group">
          <label for="price">Enter Caption:</label>
          <input
            class="form_field"
            type="text"
            placeholder="Enter Caption"
            v-model="caption"
          />
        </div>

        <div class="pure-control-group">
          <label for="stock">Enter Location:</label>
          <input
            class="form_field"
            type="text"
            placeholder="Enter Location"
            v-model="location"
          />
        </div>
        <div class="pure-control-group radio">
          <label for="radio">Enter type of Post:</label>
          <div class="new">
            <input
              type="radio"
              id="Image"
              value="Image"
              name="type"
              v-model="picked"
            />
            <section for="Image">Image</section>
          </div>

          <div class="new">
            <input
              type="radio"
              id="Video"
              value="Video"
              name="type"
              v-model="picked"
            />
            <section for="Video">Video</section>
          </div>
        </div>

        <div class="pure-controls">
          <button
            type="submit"
            class="pure-button pure-button-primary btn btn-success"
          >
            Submit
          </button>
        </div>
      </fieldset>
    </form>
    </div>
    <footerBar />
  </div>
</template>

<script>
import footerBar from './footerBar.vue'
import navBar from './navBar.vue'
export default {
  name: "addPosts",
  components:{
    footerBar,navBar
  },
  data() {
    return {
      image: "",
      caption: "",
      location: "",
      picked: "",
      user: {},
      auth: ''
    }
  },
  created(){
    
      if (sessionStorage.getItem("User")) {
      this.user = JSON.parse(sessionStorage.getItem("User"));
    }

    },
  methods: {
    addPost(e){
      e.preventDefault();

      this.axios.post('http://localhost:8082/post/add-post',{
        
            userId:this.user.id,
      location:this.location,
      caption:this.caption,
      mediaType:this.image,

likes:[],

comment:[],

      }).then(() => {
              this.$router.push("/userProfile")
      })

    }
  }
};
</script>

<style scoped>
.bg {
  width: 50%;
  margin: 80px auto;
}

.cart_heading {
  font-family: sans-serif, Verdana, Arial;
  margin: 20px 0;
  color: rgb(161, 161, 161);
}

.form {
  display: flex;
  flex-direction: column;
  padding: 30px 0;
  box-shadow: rgba(51, 51, 51, 0.55) 0px 5px 15px;
  border-radius: 8px;
  /* width: 50%; */
}

.form_field {
  padding: 6px 0;
  border-radius: 5px;
  margin: 5px 0 5px 5px;
  border: 1px solid rgb(134, 134, 134);
  color: rgb(131, 131, 131);
  width: 50%;
  text-align: center;
  background-color: rgb(240, 240, 240);
}

.btn {
  background-color: rgb(161, 161, 161);
  color: #fff;
  border-radius: 5px;
  height: 40px;
  margin: 20px 0;
 
}

.btn:hover {
  border: 1px solid rgb(161, 161, 161);
  background-color: #fff;
  color: rgb(161, 161, 161);
}

label {
  font-size: 15px;
  color: rgba(134, 134, 134);
}

.new {
  display: flex;
  align-items: center;
  margin-left: 20px;
}

.radio {
  display: flex;
}

@media (max-width: 767px) {
    .bg{
        width: 85%;
    }

    .pure-control-group
    {
        display: inline-flex;
        align-items: center;
        padding:0 20px;
    }

    .pure-controls{
        padding: 0 20px;
    }

    .form_field{
        width: 100%;
    }
}

@media (max-width:320px) {
    .bg{
        width: 100%;
        /* margin: 0 5px 0 5px; */
    }
}
</style>