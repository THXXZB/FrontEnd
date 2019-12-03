import axios, { AxiosInstance, AxiosRequestConfig, AxiosResponse } from 'axios';
import { Message } from 'element-ui';

export interface ResponseData {
  code: number;
  data: any;
  message: string;
}

// 创建axios案例
let service: AxiosInstance | any;
if (process.env.NODE_ENV === 'development') {
  // 开发环境
  service = axios.create({
    baseURL: '/api',
    // 请求超时时间
    timeout: 500000,
  });
} else {
  service = axios.create({
    baseURL: '/api',
    // 请求超时时间
    timeout: 500000,
  });
}

// request请求拦截器
service.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    return config;
  },
  (error: any) => {
    // console.log('error', error);
    return Promise.reject(error);
  },
);

// response响应拦截器
service.interceptors.response.use(
  (res: AxiosResponse) => {
    if (res.status === 200) {
      const data: ResponseData = res.data;
      if (data.code === 0) {
        return data.data;
      } else {
        Message({
          message: data.message,
          type: 'error',
        });
      }
    } else {
      Message({
        message: '网络错误！',
        type: 'error',
      });
      return Promise.reject(new Error(res.data.message || 'Error'));
    }
  },
  (error: any) => {
    return Promise.reject(error);
  },
);

export default service;
