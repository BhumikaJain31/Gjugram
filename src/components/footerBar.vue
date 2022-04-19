<template>
  <div class="footer">
    <div class="nav">
        <router-link to="/savedPosts"
          ><img src="../assets/save.png" class="save"
        /></router-link>
        <router-link to="/userNotification"
          ><font-awesome-icon icon="fa-regular fa-heart" class="icons"
        /></router-link>
        <router-link to="/userProfile"
          ><font-awesome-icon icon="fa-regular fa-user-circle" class="icons"
        /></router-link>
        
        <font-awesome-icon @click="deleteItem()"
          icon="fa-regular fa-arrow-alt-circle-right"
          class="icons"
        />
      </div>
    </div>
 
</template>

<script>

export default {
  name: "footerBar",
  components: {},
  data() {
    return {
      search: "",
    };
  },
  computed: {
    filteredPosts() {
      return this.getUser.filter(
        (post) => post.userName.includes(this.search),
      );
    },
  },
  methods: {
   
    
    deleteItem(){
        sessionStorage.removeItem("User")
        this.$router.push("/")
    },
  },

  
  created() {
    if (sessionStorage.getItem("User")) {
      this.details = JSON.parse(sessionStorage.getItem("User"));
    }
  },

};
</script>


<style scoped>

.footer{
    display: none;
}
.icons {
  width: 28px;
  height: 28px;
  text-decoration: none;
  margin: auto 10px;
  color: #000;
  cursor: pointer;
}

.logo {
  width: 130px;
  height: 50px;
}

.nav {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.footer {
  background-color: rgb(255, 255, 255);
  color: rgb(0, 0, 0);
  z-index: 3;
  width: 100%;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  
}

.save{
  width: 25px;
  height: 25px;
}

.links {
  text-decoration: none;
  color: rgb(100, 100, 100);
  display: flex;
  align-items: center;
  margin: 0 15px;
  cursor: pointer;
}

.navbar_images {
  width: 40px;
  height: 40px;
  border-radius: 100%;
  display: flex;
  align-items: center;
}



@media screen and (max-width: 500px) {
  .footer {
      padding: 10px 0;
    width: 100%;
    display: block;
  }
}
</style>