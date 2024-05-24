import express, {Request, Response} from 'express';
import mongoose from 'mongoose';

const app = express();
const port = 3000;

app.use(express.json());

// MongoDB connection
const mongoUri = 'mongodb+srv://flisc:fliscdb23fliscdb@cluster0.2eok4jh.mongodb.net/disertatie?retryWrites=true&w=majority&appName=Cluster0';
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
}, {
    versionKey: false,
    collection: 'notifications'
});

const Data = mongoose.model<INotification>('Data', dataSchema);

const testData = {
    to: 'User123',
    message: 'User1231231 a postat un articol nou'
}

// Routes
app.get('/add', (req: Request, res: Response) => {
    Data.insertMany(testData)
        .then(() => {
            console.log('Test data inserted');
            // mongoose.connection.close();
        })
        .catch((err) => {
            console.error('Error inserting test data', err);
            // mongoose.connection.close();
        });
});

app.get('/', async (req: Request, res: Response) => {
    try {
        const data = await Data.find();
        res.json(data);
    } catch (err) {
        res.status(500).send(err);
    }
});

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
