<template>
  <div>
    <el-menu
        class="el-menu-vertical-demo"
        default-active="user"
        router
        style="width: 200px;min-height: calc(100vh - 50px)">
      <el-sub-menu index="1">
        <template #title>
          <span>系统管理</span>
        </template>
        <el-menu-item index="user">用户管理</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="book">书籍管理</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>