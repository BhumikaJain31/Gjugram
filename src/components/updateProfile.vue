<template>
<div>
    <navBar />
  <div class="container">
        <form action="" class="form" @submit="formSubmit">
            <span><img src="../assets/pinstagram.jpg" alt="" class="logo"></span>
            <span class="top-text">Edit your Profile.</span>
            <input type="text" :placeholder='user.name' class="username" v-model='name' required>
            <input type="text" :placeholder="user.userName" class="username" v-model='userName' required>
            <input type="text" placeholder="Display Picture" class="username" v-model='dp' required>
            <input type="text" placeholder="Bio" class="username" v-model='bio' required>
            <input type="email" :placeholder="user.email" class="password" v-model='email' required>
            <input type="password" placeholder="Password" class="password" v-model='password' required>
            <div class="accType">
          <div class="new">
            <input
              type="radio"
              id="Public"
              value="Public"
              name="type"
              v-model="picked"
            />
            <section for="Public">Public</section>
          </div>

          <div class="new">
            <input
              type="radio"
              id="Private"
              value="Private"
              name="type"
              v-model="picked"
              
            />
            <section for="Private">Private</section>

            </div>
          </div>
          
            <input type="submit" class="submit" value="Update Profile">
        </form>
   <footerBar />
    </div>
</div>
</template>

<script>
import footerBar from './footerBar.vue'
import navBar from './navBar.vue'
export default {
 name: 'userSignUp',
 components: {
     footerBar, navBar
 },
 data() {
     return {
         name: this.user.name,
         userName: this.user.userName,
         email: this.user.email,
         password: this.user.password,
         picked: '',
         dp: '',
         bio: '',
         user: {},
         auth: '',
         checkedNames: []
     }
 },
 created(){
    

      if (sessionStorage.getItem("User")) {
      this.user = JSON.parse(sessionStorage.getItem("User"));
    }
    
   },
 methods: {
     formSubmit(e) {
                e.preventDefault();
                this.axios.put('http://localhost:8083/user/edit-profile', {
                    
                    id: this.user.id,
                    name: this.name,
                    userName: this.userName,
                    password: this.password, 
                    accType: this.picked.toLowerCase(),
                    email: this.email,
                }).then((resp) => {
                    sessionStorage.setItem('User',JSON.stringify(resp.data))
                })
               
                this.axios.put(`http://localhost:8083/user-post/update-bio-dp?userId=${this.user.id}&dp=${this.dp}&bio=${this.bio}`)

    this.$router.push("/userProfile")
                
            },
 }
}
</script>

<style scoped>

*{
    box-sizing: border-box;
}

.logo{
    width: 240px;
    height: 90px;
    
}
.container{
display: flex;
flex-direction: column;
    align-items: center;
    justify-content: center;
     text-align: center;
     margin-top: 80px;
}


.form{
    width: 350px;
    padding: 30px 0 ;
    background-color: rgb(255, 255, 255);
    border: rgb(194, 194, 194) 1px solid;
    margin:30px auto 15px auto;
    
}
.top-text, .username, .password, .submit{
    display: block;
    text-align: center;
    margin-left: auto;
    margin-right: auto;
    outline: none;
}
.top-text{
    margin: 30px auto;
    font-size: 17px;
    color: rgb(138, 138, 138);
    font-weight: bold;
    width: 90%;
}
.username, .password{
    font-size: 13px;
    margin-top: 10px;
    padding: 8px;
    background-color: rgb(245, 245, 245);
    width: 80%;
    border: solid 1px rgb(216, 216, 216);
}
.submit{
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: 15px;
    padding: 8px 15px;
    margin: 20px auto;
    width: 80%;
    background-color: #0095f6;
    border: solid 1px rgba(228, 228, 228, 0);
    border-radius: 5px;
    color: rgb(255, 255, 255);
}

.bottom_text{
    font-size: 14px;
    color: #adadad;
    font-weight: bold;
}

.login_btn{
    color: #0095f6;
    text-decoration: none;
}

.login{
     color: #acabab;
     font-weight: bold;
     background-color: #fff;
     border: solid 1px rgb(194, 194, 194) ;
     width: 350px;
}

.login > p{
    margin: 10px;
}

.accType{
    display: flex;
    justify-content: space-evenly;
    margin-top: 15px;
}

.new{
    display: flex;
}
@media (max-width: 320px) {
    .form{
        width: 100%;
        margin: 0px auto;
        border: none;
    }

    .login{
        width: 100%;
        border: none;
    }
}
</style>