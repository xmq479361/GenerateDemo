import React, {Component} from "react"

import {
	View,
	Image,
	Text,
	TextInput,
	Button,
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
                
<View style={styles.container432643} >
<View style={styles.container422394} >
<Image style={styles.icon547858}
source={require('../../public/imgs/ico_back.webp')}/>
</View>

<Text style={styles.text189133}>新建日程</Text>
<View style={styles.container304902} >
<Image style={styles.icon547858}
source={require('../../public/imgs/ico_back.webp')}/>
<Image style={styles.icon547858}
source={require('../../public/imgs/ico_back.webp')}/>
</View>

</View>
                
<View style={styles.container852522} >
<TextInput style={styles.input40292}
placeholder="请输入日程主题"/>
<TextInput style={styles.input820111}
placeholder="请输入日程内容"/>
<View style={styles.spaceView985823}/>
<View style={styles.container182027} >
<View style={styles.container218762} >
<Text style={styles.text113577}>开始</Text>
<Text style={styles.text113577}>2019/06/28 15:00</Text>
</View>

<View style={styles.spaceView300148}/>
<View style={styles.container218762} >
<Text style={styles.text113577}>结束</Text>
<Text style={styles.text113577}>2019/06/28 16:00</Text>
</View>

<View style={styles.spaceView300148}/>
<View style={styles.container218762} >
<Text style={styles.text113577}>结束22</Text>
<Text style={styles.text113577}>2019/06/28 16:00</Text>
</View>

</View>

<View style={styles.spaceView688540}/>
<View style={styles.container860954} >
<Image style={styles.icon476790}
source={require('../../public/imgs/event/ico_event_tag.png')}/>
<TextInput style={styles.input714201}
placeholder="请输入标签"/>
</View>

<Button style={styles.button389304}
title="提交"/>
</View>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    icon547858: {
        width:32,
        height:32
    },
    container422394: {
        flexDirection:"row",
        flexGrow:1
    },
    text189133: {
        flexGrow:0,
        padding:0
    },
    container304902: {
        flexDirection:"row",
        justifyContent:"flex-end",
        flexGrow:1
    },
    container432643: {
        flexDirection:"row",
        justifyContent:"space-between",
        alignItems:"center",
        alignSelf:"stretch",
        flexGrow:0,
        backgroundColor:"#CFAFFF",
        padding:5
    },
    input40292: {
        alignSelf:"stretch",
        height:50,
        margin:5,
        fontSize:15,
        color:"#545454",
        fontWeight:"bold",
        padding:0
    },
    input820111: {
        alignSelf:"stretch",
        height:50,
        marginVertical:5,
        marginHorizontal:15,
        paddingVertical:5,
        paddingHorizontal:15,
        fontSize:12,
        color:"#545454"
    },
    spaceView985823: {
        alignSelf:"stretch",
        height:1,
        backgroundColor:"#d8d8d8"
    },
    text113577: {
        flexGrow:0,
        fontSize:12,
        color:"#545454",
        padding:0
    },
    container218762: {
        flexDirection:"column",
        justifyContent:"center",
        alignItems:"center",
        flexGrow:5,
        alignSelf:"stretch"
    },
    spaceView300148: {
        alignSelf:"stretch",
        width:1,
        backgroundColor:"#b7d0d0"
    },
    container182027: {
        flexDirection:"row",
        justifyContent:"space-between",
        alignItems:"flex-start",
        alignSelf:"stretch",
        height:100
    },
    spaceView688540: {
        height:20,
        alignSelf:"stretch",
        backgroundColor:"#37d0d0"
    },
    icon476790: {
        width:32,
        height:32,
        fontSize:12,
        color:"#545454"
    },
    input714201: {
        flexGrow:1,
        height:32,
        fontSize:12,
        color:"#545454",
        padding:0
    },
    container860954: {
        flexDirection:"row",
        justifyContent:"space-between",
        alignItems:"flex-start",
        alignSelf:"stretch",
        height:50
    },
    button389304: {
        alignSelf:"stretch",
        height:50,
        fontSize:12,
        color:"#545454",
        padding:0
    },
    container852522: {
        flexDirection:"column",
        justifyContent:"flex-start",
        alignItems:"flex-start",
        flexGrow:10,
        backgroundColor:"#FFFFFF",
        margin:5
    }
});

module.exports = DemoWidgetPage;

