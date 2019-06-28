import React, {Component} from 'react'
import {connect} from 'react-redux'
import '../assets/app.css'
import {ControlLabel, FormControl, FormGroup, HelpBlock} from "react-bootstrap";

function FieldGroup({id, label, help, ...props}) {
    return (
        <FormGroup controlId={id}>
            <ControlLabel>{label}</ControlLabel>
            <FormControl {...props} />
            {help && <HelpBlock>{help}</HelpBlock>}
        </FormGroup>
    );
}

class AttributeItem extends Component {
    render() {
        let {desc, type, def, value, name} = this.props;
        if (value === undefined) {
            value = def;
        }

        // console.log(key, value, def, type, Attribute.propTypes[type])

        function renderByType(type) {
            switch (type) {
                case 'gravity':
                    return (
                        <FormGroup key={desc} controlId="formControlsSelect">
                            <ControlLabel>{name}</ControlLabel>
                            <FormControl componentClass="select" placeholder={value}>
                                <option value="left">left</option>
                                <option value="center">center</option>
                                <option value="right">right</option>
                            </FormControl>
                        </FormGroup>
                    )
                default:
                    // return (<input key={key} type="text"
                    //                autoComplete="off" className="el-input__inner"
                    //                value={def}/>
                    // return (
                    //     <FormGroup controlId="formHorizontal">
                    //         <Col componentClass={ControlLabel} sm={3}>
                    //             {name}
                    //         </Col>
                    //         <Col sm={8}>
                    //             <FormControl type="text" placeholder="Enter text" defaultValue={def}/>
                    //         </Col>
                    //     </FormGroup>
                    // )
                    return (<FieldGroup
                            id="formControlsText"
                            type="text"
                            label={name}
                            placeholder="Enter text"
                            defaultValue={def}
                        />
                    )
            }
        }

        return (
            <div key={desc} className="el-form-item el-form-item--small">
                {renderByType(type)}
            </div>
        );
    }
}

class UIAttributeBoard extends Component {
    render() {
        console.log("UIAttributeBoard: ")
        console.log(this.props.attrs)
        let {attrs} = this.props || [];
        return (
            <aside>
                <fieldset>
                    <form>
                        {attrs.map(attr => <AttributeItem {...attr}/>)}
                    </form>
                </fieldset>
            </aside>
        )
    }
}

const mapStateToProps = (state) => {
    console.log('mapStateToProps', state)
    return {
        attrs: state.focusWidget.attrs
    }
}
const mapDispatchToProps = (dispatch) => {
    return {}
}
export default connect(
    mapStateToProps,
    mapDispatchToProps)(
    UIAttributeBoard
);