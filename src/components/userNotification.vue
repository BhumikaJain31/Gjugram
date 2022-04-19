<template>
<div>
    <navBar />
  <div class = "main" >
      <div v-if="requests != []">
          <div v-for="request in requests" :key="request.id" class="hello">
         <div class="det" @click="handleUserClick(request.userId)">
         <img class="photo" :src="request.userDp" alt="" />
         <h4 class="details">{{request.userName}}</h4>
         </div>
         <div>
         <button @click="confirmFollow(request.userId, user.id)" class="btn">Confirm</button>
         <button @click="deleteOne(request.userId, user.id)" class="btn">Delete</button>
         </div>
    </div>
      </div>
      <div v-if="requests == []" >
          <h1>Nothing to display</h1>
      </div>
      <div v-for="notif in notification.slice().reverse()" :key="notif" class="hello">
          <div v-if="notif.notificationType == 'like'" class="det">
         <img class="photo" :src="notif.dp" alt="" />
         <h4 class="details">{{notif.userName}} has liked your photo</h4>
         </div>
         <div v-if="notif.notificationType == 'comment'" class="det">
         <img class="photo" :src="notif.dp" alt="" />
         <h4 class="details">{{notif.userName}} has commented on your photo</h4>
         </div>
      </div>
   </div>
   <footerBar />
  </div>
</template>

<script>
import navBar from './navBar.vue'
import footerBar from './footerBar.vue'

export default {
    name: 'userNotification',
    components: {
        navBar, footerBar
    },
    data(){
        return{
           requests: [],
           user: {},
           auth: '',
           notification: []
        }
    },
    
    created() {
        

        if (sessionStorage.getItem("User")) {
      this.user = JSON.parse(sessionStorage.getItem("User"));
    }

    

        this.axios.get(`http://localhost:8083/user-post/get-user-details-for-request?userId=${this.user.id}`)
        .then((resp) => {
            
            this.requests = resp.data
        });

        this.axios.get(`http://localhost:8083/user-post/get-all-notification-by-postUserId?postUserId=${this.user.id}`)
        .then((resp) => {
            this.notification = resp.data
        });

        
    },
    methods: {
        confirmFollow(uid,fid){
             this.axios.put(
        `http://localhost:8083/user-post/update-following-list?userId=${uid}&followingId=${fid}`
      );
      
      this.axios.delete(`http://localhost:8083/user-post/delete-request?userId=${fid}&requestId=${uid}`).then(() => {
        this.$router.go();
    });
      
        },

        deleteOne(uid,fid){
            this.axios.delete(`http://localhost:8083/user-post/delete-request?userId=${fid}&requestId=${uid}`);
    this.$router.go();
        },
        handleUserClick(userId){
            this.$router.push(`userDetails/${userId}`)
        },
        

    }

}
</script>

<style scoped>


.main{
    margin: 80px auto;
    width: 50%;
}

.hello{
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    background-color: #fff;
    margin: 10px;
    padding: 0 10px;
    border-radius: 10px;
    border: 1px solid rgb(177, 177, 177);
    justify-content: space-between;
}

.det{
     display: flex;
    align-items: center;
}
.photo{
    width: 45px;
    height: 45px;
    border-radius: 100% ;
}

.btn{
    padding: 7px 10px;
      margin: 0 10px 0 0;
      font-size: 15px;
      font-weight: bold;
      cursor: pointer;
      background-color: #0095f6;
    border: solid 1px rgba(228, 228, 228, 0);
    border-radius: 5px;
    color: rgb(255, 255, 255);
}

.details{
    margin-left: 20px;
}

@media (max-width:767px) {
    .main{
    width: 70%;
}}
@media (max-width:500px) {
    .main{
    width: 100%;
}
}


</style>