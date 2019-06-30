
import {ADD, REMOVE, UPDATE, KEY_CACHE} from './Consts'
import uiElements from '../../config/elements'
import demo from '../../config/elements/Demo'
// import uuid from 'uuid'
// TODO 加载本地缓存
const loadCache = () => {
    let cache = localStorage.getItem(KEY_CACHE)
    // console.log("loadCache", cache)
    let cacheData = {}
    if (cache != null && cache !== undefined && cache !== "") {
        cacheData = JSON.parse(cache)
    }
    // cacheData.uiElements = uiElements|| []
    cacheData.uiElements = uiElements
    // cacheData.uiPage = cacheData.uiPage || []
    cacheData.uiPage =   demo

    cacheData.focusWidget = cacheData.focusWidget || uiElements[0]
    console.log("uiElements", cacheData.focusWidget)
    console.log(typeof cacheData.uiPage)
    if (typeof cacheData.uiPage !== "object") {
        cacheData.uiPage = {}
    }
    return cacheData
}

const newInstance = (id, widgetJson)=>{
    return {
        id,
        widget: widgetJson
    }
}

// TODO 核心todo数据修改逻辑
const coreProcess = (state, action) => {
    console.log("reducer handle:: "+action.type)
    console.log(state)
    switch (action.type) {
        case ADD:
            // return Object.assign({}, state, {
            //     uiPage: [ // TODO 新建todo数据并合并入todos中
            //         ...state.uiPage, newInstance(action.id, action.widget)
            //     ]
            // })
            break;
        // case REMOVE:
        //     return Object.assign({}, state, {
        //         // TODO 这里当id 与action中id一致的情况下， 过滤条件成立，
        //         // TODO 则移除数据并赋值给todos
        //         uiPage: state.uiPage.filter(item => item.id !== action.id)
        //     })
        // case UPDATE:
        //     // TODO 修改内存中的过滤器
        //     return Object.assign({}, state, {filter: action.filter})
        default:
            break;
    }
    return state;
}
export default (state, action) => {
    let stateWithCache = state
    // TODO 检查新建缓存
    if (stateWithCache === undefined) {
        stateWithCache = loadCache()
    }

    // 真实处理逻辑
    stateWithCache = coreProcess(stateWithCache, action)

    // TODO 缓存到本地
    var cacheStr = JSON.stringify(stateWithCache);
    // console.log(cacheStr)
    localStorage.setItem(KEY_CACHE, cacheStr)
    // console.log("cacheStr: ", cacheStr)
    return stateWithCache
}