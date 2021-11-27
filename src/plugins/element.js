import ElementPlus from 'element-plus'
import '../element-variables.scss'
import { ElIcon } from 'element-plus'
import locale from 'element-plus/lib/locale/lang/zh-cn'

export default (app) => {
    app.use(ElementPlus, {locale},{ ElIcon })
}
