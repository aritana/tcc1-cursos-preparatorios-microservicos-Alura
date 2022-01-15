const response = (req, res) => {
    res.json({
        posts: [
            { title: 'first post' },
            { title: 'second post' },
        ]
    })
};
export default response;