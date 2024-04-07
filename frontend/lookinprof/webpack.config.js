import DotenvWebpackPlugin from "dotenv-webpack";

export const plugins = [new DotenvWebpackPlugin()];
export const resolve = {
  fallback: {
    util: false,
  },
};
