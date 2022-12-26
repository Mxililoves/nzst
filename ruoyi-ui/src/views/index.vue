<template>
  <div class="app-container home">

    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>南舟智能后台管理系统</h2>
        <p>
          佛山市南舟智能科技有限公司位于广东顺德，主要经营智能水务系统开发、数据可视化实施、人工智能软件应用、数据处理和技术支持。

          以基于数字世界中构建跨地域污水站管理、多设备远程管理、财务流程实时监控，数据统一分析等的业务场景；构建面向未来的城市水务管理平台，服务千万级人口的大型城市污水处理站实现数字化升级转型。

          另长期投入于原创技术研究，不断增强行业领先的财务全栈式人工智能能力，涵盖财务分析智能、财务决策智能、智能内容生成和智能内容增强等关键技术领域，大幅降低人工智能生产要素价格，实现高效率、低成本、规模化的AI创新和落地。为客户提供优异的售前、售后服务，始终坚持提供完善的产品及系统解决方案，更大限度的满足客户需求。
        </p>


        <p>
          <el-button
            size="mini"
            icon="el-icon-s-home"
            plain
            @click="goTarget('http://www.nzst.net')"
          >访问主页
          </el-button
          >
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider/>
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>公司业务</span>
          </div>
          <div class="body">
            <p>
              我们南舟将构建面向未来的企业管理运营系统，使客户实现工作流程数字化和自动化，从而精简任务并增强用户体验。南舟企业开放平台（以下简称「NZST」）用于实现互联、高效及可扩展的企业运营，为客户带来更好的业务成果。
            </p>
            <p>「NZST」是一个一站式软件平台，将来会嵌入超过100多个人工智能应用，支持各种业务，能够满足客户跨行业数据感知和流程自动化的业务需求。</p>
            <p>「NZST」能令客户能够以免代码、模块化、灵活及可扩展的方式部署。将广泛应用于诸多垂直行业，包括智慧水务，厂房租赁，商业空间管理、物业管理、财务管理、智慧城市基础设施、及智慧金融服务。</p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 官网：
              <el-link
                href="http://www.nzst.net"
                target="_blank"
              >http://www.nzst.net
              </el-link
              >
            </p>
            <p>
              <i class="el-icon-phone"></i>
              电话： 0757-26617722
            </p>
            <p>
              <i class="el-icon-message"></i> E-Mail：<a
              href="javascript:;"
            >nzst@xxx.com</a
            >
            </p>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.4",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }

  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }

  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

