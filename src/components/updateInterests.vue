<template>

<div class="page">
    <h1 class="head">Add Interests</h1>
  <div class="all_interests">
      <div class="interests">
          <img class="interest_image" src='https://imageio.forbes.com/specials-images/dam/imageserve/1138257321/960x0.jpg?fit=bounds&format=jpg&width=960'/>
          <div><input type="checkbox" id="Shopping" value="shopping" v-model="checkedNames">
<label for="Shopping">Shopping</label>
      </div></div>
      
<div class="interests">
    <img class="interest_image" src="https://blogs.worldbank.org/sites/default/files/styles/hero/public/2021-01/jaime_blog-12421shutterstock_1681937335.jpg?itok=m30IEC6J" />
    <div><input type="checkbox" id="Learning" value="learning" v-model="checkedNames">
<label for="Learning">Learning</label>
</div>
</div>

<div class="interests">
    <img class="interest_image" src="https://images.squarespace-cdn.com/content/v1/53b839afe4b07ea978436183/1608506169128-S6KYNEV61LEP5MS1UIH4/traditional-food-around-the-world-Travlinmad.jpg" />
    <div><input type="checkbox" id="Food" value="food" v-model="checkedNames">
<label for="Food">Food</label>
</div>
</div>

<div class="interests">
    <img class="interest_image" src="https://www.globalfocusmagazine.com/wp-content/uploads/2020/02/Engaging_with_technology-scaled.jpg" alt="">
    <div><input type="checkbox" id="Technology" value="technology" v-model="checkedNames">
<label for="Technology">Technology</label>
</div>
</div>

<div class="interests">
        <img class="interest_image" src="https://blog.ipleaders.in/wp-content/uploads/2021/06/featured.jpg" alt="">

    <div><input type="checkbox" id="Entertainment" value="entertainment" v-model="checkedNames">
    <label for="Entertainment">Entertainment</label>
</div>
</div>
  </div>
<button @click="confirmAll" class="btn">Confirm</button>
<br>

  </div>
</template>

<script>
export default {
name: 'updateInterests',
props: [
    'property'
],
data(){
    return{
        checkedNames: [],
        auth: ''
    }
},
created(){
    

},
    

methods: {
    confirmAll(){
        this.axios.put(`http://localhost:8083/user/interest`, {
            id: this.property.id,
            name: this.property.name,
                    userName: this.property.userName,
                    password: this.property.password, 
                    accType: this.property.picked,
                    email: this.property.email,
                    interest: this.checkedNames
        })

        this.axios.post('http://10.20.2.212:8082/Ads/User', {
                platform: "pinstagram",
                userName: this.property.userName,
                interests: this.checkedNames
            })
            this.$router.push("/")
    }
}
}
</script>

<style scoped>

.interests{
    display: flex;
    text-align: center;
    flex-direction: column;
    margin:20px;
}

.interest_image{
    width: 250px;
    height: 250px;
    border-radius: 20px
}

.all_interests{
    margin: auto;
    display: flex;
    flex-wrap: wrap;
    width: 80%;
    justify-content: center;
    align-items: center;
}

.btn{
    padding: 7px 10px;
      margin: 10px 0 0 0;
      font-size: 15px;
      font-weight: bold;
      cursor: pointer;
      background-color: #0095f6;
    border: solid 1px rgba(228, 228, 228, 0);
    border-radius: 5px;
    color: rgb(255, 255, 255);
    
}

.page{
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

@media (max-width: 767px) {
    
.interest_image{
    width: 150px;
    height: 150px;
    border-radius: 20px
}



}
@media (max-width: 420px) {
    
.interest_image{
    width: 120px;
    height: 120px;
    border-radius: 20px
}

}

@media (max-width: 320px) {
    
.interest_image{
    width: 100px;
    height: 100px;
    border-radius: 20px
}

.interests{
    margin: 10px;
    font-size: 12px;
}

.head{
    font-size: 15px;
}

}
</style>