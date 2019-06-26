import { createStore } from 'redux'
import pageReducer from '../business/widgets/reducers'
// import pageReducer from '../business/widgets/reducers'

export default createStore(
    pageReducer
)