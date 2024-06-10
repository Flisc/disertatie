import axios from 'axios';
import express, {Request, Response} from 'express';
import mongoose from 'mongoose';

const app = express();
const port = 3000;

app.use(express.json());

// MongoDB connection
const mongoUri = 'mongodb+srv://flisc:fliscdb@cluster0.2eok4jh.mongodb.net/disertatie?retryWrites=true&w=majority&appName=Cluster0';
const USER_API = 'http://localhost:8082/users';
mongoose.connect(mongoUri)
    .then(() => console.log('Connected to MongoDB Atlas'))
    .catch((err) => console.error('Could not connect to MongoDB Atlas', err));

interface INotification extends mongoose.Document {
    to: string;
    message: string;
}

const dataSchema = new mongoose.Schema({
    to: {type: String, required: true},
    message: {type: String, required: true},
    date: {type: Date}
}, {
    versionKey: false,
    collection: 'notifications'
});

const Data = mongoose.model<INotification>('Data', dataSchema);


// Routes
app.get('/addTestData', (req: Request, res: Response) => {
    insertTestData();
});

app.get('/notifications/users/:currentUser/subscribe/:to', async (req: Request, res: Response) => {
    let notification = {
        to: 'Blog',
        message: `Utilizatorul [${req.params.currentUser}] s-a abonat la blogul utilizatorului [${req.params.to}]`,
        date: new Date()
    }
    console.log(notification)
    // storeNotification(notification)
    res.json(notification)

});

app.get('/notifications/newArticle/:articleId/user/:userId', async (req: Request, res: Response) => {
    let userId = req.params.userId
    let articleId = req.params.articleId

    let notifRes = {
        to: `User: ${userId}`,
        message: `Utilizatorul [${userId}] a publicat un articol nou, art[${articleId}]`,
        date: new Date()
    }
    let user = await getUserById(userId)
    // @ts-ignore
    if (user.subscribedUsers.length != 0) {
        // @ts-ignore
        user.subscribedUsers.forEach(usrId => {
            console.log({
                to: `User: ${usrId}`,
                message: `Utilizatorul [${userId}] a publicat un articol nou, art[${articleId}]`,
                date: new Date()
            })
        })
    }
    // console.log(notifRes)
    res.json(notifRes)
});

app.get('/', async (req: Request, res: Response) => {
    try {
        const data = await Data.find();
        res.json(data[0]);
    } catch (err) {
        res.status(500).send(err);
    }
});

async function getUserById(userId: any) {
    try {
        const response = await axios.get(`${USER_API}/${userId}`);
        // console.log(response.data)
        return response.data;
    } catch (error) {
        console.error(error);
        // res.status(500).send('Something went wrong');
    }
}

function insertTestData() {
    const testData = {
        to: 'User123',
        message: 'User1231231 a postat un articol nou'
    }
    Data.insertMany(testData)
        .then(() => {
            console.log('Test data inserted');
        })
        .catch((err) => {
            console.error('Error inserting test data', err);
        });
}

function storeNotification(data: any) {
    Data.insertMany(data)
        .then(() => {
            console.log('Data notification inserted');
        })
        .catch((err) => {
            console.error('Error inserting data', err);
        });
}

app.listen(port, () => {
    console.log(`Notification Server is running on http://localhost:${port}`);
});