// utils/request.js
import {
  BASE_URL
} from "./util.js";

// 通用请求封装 代理
const request = (options) => {
  // 1. 从本地缓存拿token
  const token = wx.getStorageSync("token");

  // 2. 组装请求头
  let header = {
    "Content-Type": "application/json"
  };

  // 有token就自动带上
  if (token) {
    header["token"] = token; // 强制小写，别写成 header.token
  }


  // 3. 返回Promise 方便调用
  return new Promise((resolve, reject) => {
    wx.request({
      url: BASE_URL + options.url,
      method: options.method || "GET",
      header: header,
      data: options.data || {},
      success: (res) => {
        // 统一简单校验
        if (res.data.code === 401) {
          wx.showToast({
            title: "登录已过期，请重新登录",
            icon: "none"
          });
          // 可清空token 跳登录页
          wx.removeStorageSync("token");
          return;
        }
        resolve(res.data);
      },
      fail: (err) => {
        wx.showToast({
          title: "网络请求失败",
          icon: "none"
        });
        reject(err);
      }
    })
  })
};

export default request;