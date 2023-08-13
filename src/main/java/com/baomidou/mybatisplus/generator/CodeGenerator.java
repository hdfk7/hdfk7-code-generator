package com.baomidou.mybatisplus.generator;

public class CodeGenerator {
    static final String URL = "jdbc:mysql://10.10.10.10:3306/test?serverTimezone=GMT%2B8";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");//获取项目路径
        FastAutoGenerator.create(URL, "root", "password")
                //全局配置
                .globalConfig(builder -> {
                    builder.author("")
                            .outputDir(projectPath + "/src/main/java")
                            .enableSpringdoc()
                            .disableServiceInterface()
                            .disableOpenDir();
                })
                //包名配置
                .packageConfig(builder -> {
                    builder.parent("com.hdfk7.module")
                            .controller("controller")
                            .service("infrastructure")
                            .serviceImpl("infrastructure")
                            .entity("domain.entity")
                            .mapper("infrastructure.mapper")
                            .xml("infrastructure.mapper.xml");
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("test")
                            .controllerBuilder().enableRestStyle().enableHyphenStyle().enableFileOverride()
                            .serviceBuilder().enableFileOverride().formatServiceImplFileName("%sRepository")
                            .entityBuilder().enableLombok();
                })
                //执行
                .execute();
    }
}
