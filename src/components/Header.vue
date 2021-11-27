<template>
  <div style="height: 50px; line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="width: 200px;padding-left:50px;font-weight: bolder">后台管理</div>
    <div style="flex: 1"></div>
    <div style="width:120px">
      <el-dropdown>
    <span class="el-dropdown-link">
     张子枫<svg style="width: 1em; height: 1em;margin-left: 1px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1024 1024" data-v-394d1fd8=""><path fill="currentColor" d="M831.872 340.864 512 652.672 192.128 340.864a30.592 30.592 0 0 0-42.752 0 29.12 29.12 0 0 0 0 41.6L489.664 714.24a32 32 0 0 0 44.672 0l340.288-331.712a29.12 29.12 0 0 0 0-41.728 30.592 30.592 0 0 0-42.752 0z"></path></svg>

    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/person')">个人信息</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/login')">退出</el-dropdown-item>

          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>

  </div>
</template>
<script>
export default {
  name: "Header.vue"
}
</script>

<style scoped>

</style>