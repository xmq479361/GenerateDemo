import React, {Component} from 'react'
import {connect} from 'react-redux'
// import '../assets/app.css'
import '../assets/preview.css'

const push = (source, attr) => {
    return Object.assign({}, source, attr)
}
const getClassNameByGrow = (clzName, grow = undefined) => {
    if (grow) {
        clzName += " flex-grow-" + grow;
    }
    return clzName
}

const isValidGrow =(value)=>{
    return /^\d+$/.test(value);
}


// const getSpan = (size) => {
//     let res = size * 2 / 100;
//     console.log("getSpan", res);
//     return res;
// }
// class FlexDirection {
//
// }
//
// class FlexJustify {
//
// }
//
// class FlexAlignItem {
//
// }
class FlexStrag {
    constructor(direction, justify, alignItems) {
        this.direction = direction;
        this.justify = direction;
        this.alignItems = alignItems;
    }
    attachStyleAndAttrs(width, height, child, clzName){
        let attrs = {}
        let style = {}
        let {background = ""} = child
        if (background) {
            style = push(style, {'background-color': background})
        }
        if (height.endsWith("px")) {
            style = push(style, {height: height})
            // }else{
            //     style= Object.assign({},style, {span: this.getSpan(height)})
        }
        if (width.endsWith("px")) {
            style = push(style, {width: width})
        } else if (width === "-1") {
            // style = push(style, {width: childWidth})
            clzName = getClassNameByGrow("", 0);
        }
        return {clzName, style, attrs};
    }

    getRenderInput(child, clzName, style) {
        let {hint = "", text = ""} = child
        let {height} = style;
        if(height){
            style = push(style, {'line-height': height})
        }
        let attrs ={}
        console.log(attrs);
        if(text){
            attrs.push({defaultValue: text})
        }
        attrs.push({placeholder:hint})
        return {clzName, style, attrs}
    }
    renderInput(child, clzName, style, attrs) {
        let {hint = "", text = ""} = child
        let {height} = style;
        if(height){
            style = push(style, {'line-height': height})
        }
        console.log(attrs);
        if(text){
            attrs = push(attrs, {defaultValue: text})
        }
        // attrs.push({placeholder:hint})
        attrs = push(attrs, {placeholder: hint})
        return (<input className={clzName} style={style} {...attrs} type="text"/>)
    }
    renderImage=(child, clzName, style, attrs)=>{
        let {src = ""} = child
        if(src){
            attrs = {src: require('../assets/'+src)}
        }
        return (<img className={clzName} style={style} {...attrs}/>)
    }
    getItemRender = (childWidth, childHeight, child, grow = undefined) => {
        let {type} = child
        let {clzName, style, attrs} = this.attachStyleAndAttrs(childWidth, childHeight, child, getClassNameByGrow("", grow));
        let {text = ""} = child
        let {height} = style;
        switch (type) {
            case 'text':
                if(height){
                    style = push(style, {'line-height': height})
                }
                return (<label className={clzName} style={style} {...attrs}>{text}</label>)
            case 'input':
                return this.renderInput(child, clzName, style, attrs)
            case 'icon':
                return this.renderImage(child, clzName, style, attrs)
            default:
                return (
                    <div className={clzName} style={style} {...attrs}/>
                )
        }
    }


    getLayoutFromChild = (child, grow = undefined) => {
        let {width, height, type} = child
        console.log("getLayoutFromChild", type, width, height, grow);
        switch (type.toLowerCase()) {
            case "container":
                return this.getLayoutFromContainer(child, grow);
            default:
                return this.getItemRender(width, height, child, grow);
        }
    }
    getLayoutFromContainer = (container, grow = undefined) => {
        let {
            flex_direction = 'column',
            justify_content = 'start',
            align_items = 'start',
            width,
            height,
            children = []
        } = container;
        console.log("getLayoutFromContainer", flex_direction, justify_content, align_items);
        let flexStrag = new FlexStrag(flex_direction, justify_content, align_items);
        let childGrowMax = 0;
        let childGrowCount = 0;
        let childWraps = []
        let childGrows = []
        switch (flex_direction) {
            case 'row':
                childGrows = children.map(child => {
                    let {width, height, type} = child
                    console.log("childSize width: ", type, width, height);
                    if (isValidGrow(width)) {
                        childGrowMax += parseInt(width);
                        childGrowCount++
                    } else if (width === '-1') {
                        childWraps.push(child)
                    }
                    return width
                })
                break;
            case 'column':
                childGrows = children.map(child => {
                    let { height, type} = child
                    console.log("childSize height: ", type, width, height);
                    if (isValidGrow(height)) {
                        childGrowMax += parseInt(height);
                        childGrowCount++
                    } else if (height === '-1') {
                        childWraps.push(child)
                    }
                    return height
                })
            default:
                break;
        }
        let growKey = 1;
        if (childGrowCount > 0) {
            growKey = childGrowCount / childGrowMax
        }
        console.log("row childSize: ", children.length, childGrowMax, childGrowCount,
            JSON.stringify(childGrows), childWraps.length, growKey)
        let classNameAtt = getClassNameByGrow("",grow);
        switch (flex_direction) {
            case 'row':
                classNameAtt += " flex-group-row";
                break;
            case 'column':
                classNameAtt += " flex-group-column";
            default:
                break;
        }
        let {clzName, style, attrs} = this.attachStyleAndAttrs(width, height, container, classNameAtt);
        return (
            <div className={clzName} style={style} {...attrs}>
                {children.map(child => {
                    let {width} = child;
                    if(isValidGrow(width)){
                        return flexStrag.getLayoutFromChild(child, width * growKey)
                    }else{
                        return flexStrag.getLayoutFromChild(child, undefined)
                    }
                })}
            </div>
        )
    }
}

class UIPreviewBoard extends Component {

    renderContainer = (container) => {
        let {
            type,
            flex_direction = 'column',
            justify_content = 'start',
            align_items = 'start',
            children = []
        } = container;
        let childCount = children.length
        console.log("getItemRender: ", type, childCount)
        let flexStrag = new FlexStrag(flex_direction, justify_content, align_items);
        return (
            <div>
                {flexStrag.getLayoutFromChild(container)}
            </div>
        )
    }


    render() {
        let {uiPage = {}} = this.props;
        console.log("UIPreviewBoard:: ")
        console.log(uiPage);
        return (
            <div>
                <div className="flex-group">
                    <div className="item">test1</div>
                    <div className="itemWrap">test2</div>
                    <div className="item">test3</div>
                </div>
                <div className="flex-group">
                    <div className="item">test1</div>
                    <div className="itemWrap">tessdfsdfsdt2</div>
                    <div className="item">test3</div>
                </div>
                <div className="flex-group">
                    <div className="item">test1</div>
                    <div className="itemFixed">test2</div>
                    <div className="item">test3</div>
                </div>
                {this.renderContainer(uiPage)}
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        uiPage: state.uiPage
    }
}
const mapDispatchToProps = (dispatch) => {
    return {
    }
}
export default connect(
    mapStateToProps,
    mapDispatchToProps
)(UIPreviewBoard);

