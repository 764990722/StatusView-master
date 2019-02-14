# StatusView：简单的 Android 页面多状态布局切换控件

### 一、效果预览
![](images/demos.gif)
### 二、主要功能
* 可在 Activity、Fragment 、XML 中使用，可作用于 XML 的根布局 View 或其子 View
* 默认支持 Loading、Empty、Error 三种状态布局，可进行常规配置
* 可自定义状态布局，并提供对应接口来完成需要的配置
* 状态布局懒加载，仅在初次显示时初始化

### 三、使用
```·
##### 1、切换状态布局
```java
statusView.showLoadingView();
statusView.showEmptyView();
statusView.showErrorView();
statusView.showContentView(); // 即原始的页面内容布局
```·
##### 2、更自由的用法
如果不想局限于 Loading、Empty、Error 三种状态，那么下面的用法会更适合你：
```java
// 添加指定索引对应的状态布局
statusView.setStatusView(int index, @LayoutRes int layoutId)
// 为指定索引的状态布局设置初次显示的监听事件，用来进行状态布局的相关初始化
statusView.setOnStatusViewConvertListener(int index, StatusViewConvertListener listener)
// 显示指定索引的状态布局
statusView.showStatusView(int index)
```·