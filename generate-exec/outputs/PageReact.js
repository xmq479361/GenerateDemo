import React, {Component} from "react"
import {
    View,
    Text,
    TextInput,
    Image,
    Dimensions,
    Platform,
    StyleSheet,
    PixelRatio
} from 'react-native'

let screenWidth = Dimensions.get('window').width;
let screenHeight = Dimensions.get('window').height;
let ratio = Dimensions.get('window').ratio;

class DemoWidgetPage extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <View style={ {
                flex: 1,
                flexDirection: 'column',
                justifyContent: 'flex-start',
            } }>
                
<View style={ styles.container991202 }   >
<View style={ styles.container307735 }   >
<Image style={ styles.icon845478 }  source={ require('../../public/imgs/ico_back.webp') } ></Image></View>

<Text style={ styles.text807641 }   >新建日程</Text>
<View style={ styles.container116242 }   >
<Image style={ styles.icon845478 }  source={ require('../../public/imgs/ico_back.webp') } ></Image>
<Image style={ styles.icon845478 }  source={ require('../../public/imgs/ico_back.webp') } ></Image></View>
</View>
                
<View style={ styles.container941834 }   >
<TextInput style={ styles.input308699 }  placeholder={ "请输入日程主题" } ></TextInput>
<TextInput style={ styles.input419992 }  placeholder={ "请输入日程内容" } ></TextInput>
<View style={ styles.spaceView274542 }   ></View>
<View   ></View>
<View style={ styles.container395188 }   >
<View style={ styles.container74667 }   >
<Text style={ styles.text744130 }   >开始</Text>
<Text style={ styles.text744130 }   >2019/06/28 15:00</Text></View>

<View style={ styles.spaceView759612 }   ></View>
<View   ></View>
<View style={ styles.container74667 }   >
<Text style={ styles.text744130 }   >结束</Text>
<Text style={ styles.text744130 }   >2019/06/28 16:00</Text></View>
</View>

<View style={ styles.spaceView920577 }   ></View>
<View   ></View>
<View style={ styles.container670233 }   >
<Image style={ styles.icon845478 }  source={ require('../../public/imgs/event/ico_event_tag.png') } ></Image>
<TextInput style={ styles.input913714 }  placeholder={ "请输入标签" } ></TextInput></View>

<Button style={ styles.button352638 }  color={ "#545454" }accessibilityLabel={ "提交" } >提交</Button></View>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    icon845478: {
        width:32,
        height:32
    },
    container307735: {
        flexGrow:1,
        flexDirection:"row",
        flex:1
    },
    text807641: {
        flexGrow:0,
        padding:0
    },
    container116242: {
        flexGrow:1,
        flexDirection:"row",
        justifyContent:"flex-end",
        flex:1
    },
    container991202: {
        padding:5,
        backgroundColor:"#CFAFFF",
        flexDirection:"row",
        justifyContent:"space-between",
        alignItems:"center",
        flex:1
    },
    input308699: {
        alignSelf:"stretch",
        height:50,
        margin:5,
        padding:0,
        fontSize:15,
        color:"#545454",
        fontWeight:"bold"
    },
    input419992: {
        alignSelf:"stretch",
        height:50,
        marginVertical:5,
        marginHorizontal:15,
        paddingVertical:5,
        paddingHorizontal:15,
        fontSize:12,
        color:"#545454"
    },
    spaceView274542: {
        alignSelf:"stretch",
        height:1,
        backgroundColor:"#d8d8d8"
    },
    text744130: {
        flexGrow:0,
        padding:0,
        fontSize:12,
        color:"#545454"
    },
    container74667: {
        flexGrow:5,
        alignSelf:"stretch",
        flexDirection:"column",
        justifyContent:"center",
        alignItems:"center",
        flex:1
    },
    spaceView759612: {
        width:1,
        alignSelf:"stretch",
        backgroundColor:"#b7d0d0"
    },
    container395188: {
        alignSelf:"stretch",
        height:100,
        flexDirection:"row",
        justifyContent:"space-between",
        alignItems:"flex-start",
        flex:1
    },
    spaceView920577: {
        alignSelf:"stretch",
        height:20,
        backgroundColor:"#37d0d0"
    },
    input913714: {
        flexGrow:1,
        height:32,
        padding:0,
        fontSize:12,
        color:"#545454"
    },
    container670233: {
        alignSelf:"stretch",
        height:50,
        flexDirection:"row",
        justifyContent:"space-between",
        alignItems:"flex-start",
        flex:1
    },
    button352638: {
        alignSelf:"stretch",
        height:50,
        padding:0,
        fontSize:12,
        color:"#545454"
    },
    container941834: {
        flexGrow:10,
        margin:5,
        backgroundColor:"#FFFFFF",
        flexDirection:"column",
        justifyContent:"flex-start",
        alignItems:"flex-start",
        flex:1
    }
});

module.exports = DemoWidgetPage;

